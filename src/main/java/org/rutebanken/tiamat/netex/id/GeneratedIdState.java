package org.rutebanken.tiamat.netex.id;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
public class GeneratedIdState {

    public static final int QUEUE_CAPACITY = 100;
    public static final String LAST_IDS_FOR_ENTITY = "lastIdsForEntities";
    public static final String CLAIMED_IDS_FOR_ENTITY_PREFIX = "claimedIdsForEntities";

    private final HazelcastInstance hazelcastInstance;

    @Autowired
    public GeneratedIdState(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public void registerEntityTypeName(String entityTypeName, long startLastId) {
        hazelcastInstance.getMap(LAST_IDS_FOR_ENTITY).putIfAbsent(entityTypeName, startLastId);
    }

    public BlockingQueue<Long> getQueueForEntity(String entityTypeName) {
        return hazelcastInstance.getQueue(entityTypeName);
    }

    public void setLastIdForEntity(String entityTypeName, long lastId) {
        hazelcastInstance.getMap(LAST_IDS_FOR_ENTITY).put(entityTypeName, lastId);
    }

    public long getLastIdForEntity(String entityTypeName) {
        ConcurrentMap<String, Long> lastIdMap = hazelcastInstance.getMap(LAST_IDS_FOR_ENTITY);
        return lastIdMap.get(entityTypeName);
    }

    public List<Long> getClaimedIdQueueForEntity(String entityTypeName) {
        return hazelcastInstance.getList(CLAIMED_IDS_FOR_ENTITY_PREFIX + "-" + entityTypeName);
    }
}
