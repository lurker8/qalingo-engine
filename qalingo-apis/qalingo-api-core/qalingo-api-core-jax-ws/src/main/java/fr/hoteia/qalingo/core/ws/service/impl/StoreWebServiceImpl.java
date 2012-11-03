package fr.hoteia.qalingo.core.ws.service.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.hoteia.qalingo.core.common.domain.Store;
import fr.hoteia.qalingo.core.common.service.StoreService;
import fr.hoteia.qalingo.core.ws.pojo.StoreWsPojo;
import fr.hoteia.qalingo.core.ws.service.StoreWebService;

@WebService(endpointInterface="fr.hoteia.qalingo.core.ws.service.StoreWebService")
@Service("storeWebService")
public class StoreWebServiceImpl implements StoreWebService {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected StoreService storeService;
	
	public StoreWsPojo getStoreById(String storeId){
		Store store = storeService.getStoreById(storeId);
		StoreWsPojo storeWsPojo = buildStoreWsPojo(store);
		return storeWsPojo;
	}
	
	protected StoreWsPojo buildStoreWsPojo(Store store){
		StoreWsPojo storeWsPojo = new StoreWsPojo();
		storeWsPojo.setBusinessName(store.getBusinessName());
	
		// TODO : ...
	
		return storeWsPojo;
	}
}
