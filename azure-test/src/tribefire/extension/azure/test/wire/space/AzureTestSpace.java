// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
package tribefire.extension.azure.test.wire.space;

import tribefire.extension.azure.test.wire.contract.AzureTestContract;
import com.braintribe.gm.service.access.api.AccessProcessingConfiguration;
import com.braintribe.gm.service.access.wire.common.contract.AccessProcessingConfigurationContract;
import com.braintribe.gm.service.access.wire.common.contract.CommonAccessProcessingContract;
import com.braintribe.gm.service.wire.common.contract.CommonServiceProcessingContract;
import com.braintribe.gm.service.wire.common.contract.ServiceProcessingConfigurationContract;
import com.braintribe.model.generic.eval.Evaluator;
import com.braintribe.model.processing.securityservice.commons.service.InMemorySecurityServiceProcessor;
import com.braintribe.model.processing.service.common.ConfigurableDispatchingServiceProcessor;
import com.braintribe.model.processing.session.api.persistence.PersistenceGmSessionFactory;
import com.braintribe.model.service.api.ServiceRequest;
import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;
import com.braintribe.wire.api.context.WireContextConfiguration;

@Managed
public class AzureTestSpace implements AzureTestContract {
	
	@Import
	private AccessProcessingConfigurationContract accessProcessingConfiguration;
	
	@Import
	private CommonAccessProcessingContract commonAccessProcessing;

	@Import
	private ServiceProcessingConfigurationContract serviceProcessingConfiguration;
	
	@Import
	private CommonServiceProcessingContract commonServiceProcessing;
	
	@Override
	public void onLoaded(WireContextConfiguration configuration) {
		accessProcessingConfiguration.registerAccessConfigurer(this::configureAccesses);
		serviceProcessingConfiguration.registerServiceConfigurer(this::configureServices);
		serviceProcessingConfiguration.registerSecurityConfigurer(this::configureSecurity);
	}
	
	private void configureAccesses(AccessProcessingConfiguration configuration) {
		// TODO register accesses and tested access service request processors
		/* 
			configuration.registerAccess("some.access", someModel());
			configuration.registerAccessRequestProcessor(SomeAccessServiceRequest.T, someAccessServiceRequestProcessor());
		*/
	}
	
	private void configureServices(ConfigurableDispatchingServiceProcessor bean) {
		bean.removeInterceptor("auth");
		// TODO register or remove interceptors and register tested service processors
		/*
			bean.registerInterceptor("someInterceptor");
			bean.removeInterceptor("someInterceptor");
			bean.register(SomeServiceRequest.T, someServiceProcessor());
		*/
	}
	
	private void configureSecurity(InMemorySecurityServiceProcessor bean) {
		// TODO add users IF your requests are to be authorized while testing
		// (make sure the 'auth' interceptor is not removed in that case in the 'configureServices' method)
		/* 
			User someUser = User.T.create();
			user.setId("someUserId");
			user.setName("someUserName");
			user.setPassword("somePassword");
	
			bean.addUser(someUser);
		*/
	}
	
	@Override
	public Evaluator<ServiceRequest> evaluator() {
		return commonServiceProcessing.evaluator();
	}
	
	@Override
	public PersistenceGmSessionFactory sessionFactory() {
		return commonAccessProcessing.sessionFactory();
	}
	
}
