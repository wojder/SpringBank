package pl.training.service.persistence;

import pl.training.domain.Client;

public interface ClientRepository {

    Client save(Client client);

}
