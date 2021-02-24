package it.previnet.progettofermi.application.adapter;

import it.previnet.progettofermi.application.adapter.mapper.NominativoEntityNominativoInfoMapper;
import it.previnet.progettofermi.application.port.ExampleManager;
import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.repository.port.NominativoRepository;
import it.previnet.progettofermi.application.adapter.util.BeanUtil;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class ExampleManagerImpl implements ExampleManager {

    private static final Logger logger = Logger.getLogger(ExampleManagerImpl.class);

    @Inject
    NominativoRepository exampleRepository;

    @Inject
    NominativoEntityNominativoInfoMapper exampleEntityExampleInfoMapper;

    @Inject
    BeanUtil beanUtil;

    @Override
    @Transactional
    public List<ExampleInfo> fetch(NominativoSearch exampleSearch) {
        return exampleRepository.fetch(exampleSearch).stream().map(exampleEntityExampleInfoMapper::mapEntityToBean).collect(Collectors.toList());
    }

}
