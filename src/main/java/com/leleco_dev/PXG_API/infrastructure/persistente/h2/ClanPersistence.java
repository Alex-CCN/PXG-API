package com.leleco_dev.PXG_API.infrastructure.persistente.h2;

import com.leleco_dev.PXG_API.core.domain.entity.Clan;
import com.leleco_dev.PXG_API.core.port.out.clans.ClanRepositoryPortOut;
import com.leleco_dev.PXG_API.infrastructure.persistente.h2.model.ClanEntity;
import com.leleco_dev.PXG_API.infrastructure.persistente.h2.model.ClanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ClanPersistence implements ClanRepositoryPortOut {

    private final ClanRepository repository;

    private final ModelMapper mapper;

    @Override
    public Clan findById(String id) {
        Optional<ClanEntity> clanEntityOptional = repository.findById(id);
        return clanEntityOptional.map(clanEntity -> mapper.map(clanEntity, Clan.class)).orElse(null);
    }

    @Override
    public Clan save(Clan domain) {
        ClanEntity clanEntity = repository.save(mapper.map(domain, ClanEntity.class));
        return mapper.map(clanEntity, Clan.class);
    }

    @Override
    public void deleteById(String id) {
        Optional<ClanEntity> clanEntityOptional = repository.findById(id);

        if(clanEntityOptional.isEmpty()) {
            throw new RuntimeException("Clan could not be deleted because it was not found");
        }
        repository.delete(clanEntityOptional.get());
        //repository.deleteById(clanEntityOptional.get().getId());

    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public Clan update(Clan domain) {
        ClanEntity clanEntity = repository.save(mapper.map(domain, ClanEntity.class));
        return mapper.map(clanEntity, Clan.class);
    }
}
