package pl.training.service.persistence;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.training.domain.Client;

public class SynchronizedMapClientRepository implements ClientRepository {

    private final Map<Long, Client> clients = new LinkedHashMap<>();

    private long lastId;

    @Override
    public synchronized Client save(Client client) {
        client.setId(++lastId);
        clients.put(lastId, client);
        return client;
    }

}
