package com.leleco_dev.PXG_API.infrastructure.persistente.h2;

import com.leleco_dev.PXG_API.core.domain.entity.Clan;
import com.leleco_dev.PXG_API.core.port.out.clans.ClanRepositoryPortOut;
import com.leleco_dev.PXG_API.infrastructure.persistente.h2.model.ClanEntity;
import com.leleco_dev.PXG_API.infrastructure.persistente.h2.model.ClanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Component

@Repository
public class ClanPersistence implements ClanRepositoryPortOut {

    private  ClanRepository repository;

    private ModelMapper mapper;
    @Autowired
    public ClanPersistence(ClanRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

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
