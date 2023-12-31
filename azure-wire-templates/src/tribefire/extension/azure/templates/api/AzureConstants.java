// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License along with this library; See http://www.gnu.org/licenses/.
// ============================================================================
package tribefire.extension.azure.templates.api;

public interface AzureConstants {

	String GROUPID = "tribefire.extension.azure";

	String MODULE_GLOBAL_ID = "module://" + GROUPID + ":azure-module";

	String DEPLOYMENT_MODEL = GROUPID + ":azure-deployment-model";
	String SERVICE_MODEL = GROUPID + ":azure-api-model";
	String DATA_MODEL = GROUPID + ":azure-model";

}
