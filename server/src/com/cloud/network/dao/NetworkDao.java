// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.network.dao;

import java.util.List;
import java.util.Map;

import com.cloud.network.Network;
import com.cloud.network.Network.GuestType;
import com.cloud.network.NetworkAccountVO;
import com.cloud.network.NetworkVO;
import com.cloud.network.Networks.TrafficType;
import com.cloud.utils.db.GenericDao;
import com.cloud.utils.db.SearchBuilder;

public interface NetworkDao extends GenericDao<NetworkVO, Long> {

    List<NetworkVO> listByOwner(long ownerId);

    List<NetworkVO> listBy(long accountId, long offeringId, long dataCenterId);

    List<NetworkVO> listBy(long accountId, long dataCenterId, String cidr);

    List<NetworkVO> listByZoneAndGuestType(long accountId, long dataCenterId, Network.GuestType type, Boolean isSystem);

    NetworkVO persist(NetworkVO network, boolean gc, Map<String, String> serviceProviderMap);

    SearchBuilder<NetworkAccountVO> createSearchBuilderForAccount();

    List<NetworkVO> getNetworksForOffering(long offeringId, long dataCenterId, long accountId);

    @Override
    @Deprecated
    NetworkVO persist(NetworkVO vo);

    /**
     * Retrieves the next available mac address in this network configuration.
     * 
     * @param networkConfigId
     *            id
     * @return mac address if there is one. null if not.
     */
    String getNextAvailableMacAddress(long networkConfigId);

    List<NetworkVO> listBy(long accountId, long networkId);

    long countByZoneAndUri(long zoneId, String broadcastUri);
    
    long countByZoneUriAndGuestType(long zoneId, String broadcastUri, GuestType guestType);

    List<NetworkVO> listByZone(long zoneId);

    void changeActiveNicsBy(long networkId, int nicsCount);

    int getActiveNicsIn(long networkId);

    List<Long> findNetworksToGarbageCollect();

    void clearCheckForGc(long networkId);

    List<NetworkVO> listByZoneSecurityGroup(Long zoneId);

    void addDomainToNetwork(long networkId, long domainId, Boolean subdomainAccess);

    List<NetworkVO> listByPhysicalNetwork(long physicalNetworkId);

    List<NetworkVO> listSecurityGroupEnabledNetworks();

    List<NetworkVO> listByPhysicalNetworkTrafficType(long physicalNetworkId, TrafficType trafficType);

    List<NetworkVO> listBy(long accountId, long dataCenterId, Network.GuestType type, TrafficType trafficType);

    List<NetworkVO> listByPhysicalNetworkAndProvider(long physicalNetworkId, String providerName);

    void persistNetworkServiceProviders(long networkId, Map<String, String> serviceProviderMap);

    boolean update(Long networkId, NetworkVO network, Map<String, String> serviceProviderMap);

    List<NetworkVO> listByZoneAndTrafficType(long zoneId, TrafficType trafficType);

    void setCheckForGc(long networkId);
    
    int getNetworkCountByNetworkOffId(long networkOfferingId);
    
    long countNetworksUserCanCreate(long ownerId);

    List<NetworkVO> listSourceNATEnabledNetworks(long accountId, long dataCenterId, GuestType type);
    
    int getNetworkCountByVpcId(long vpcId);
    
    List<NetworkVO> listByVpc(long vpcId);
    
    NetworkVO getPrivateNetwork(String broadcastUri, String cidr, long accountId, long zoneId);
    
    long countVpcNetworks(long vpcId);

}
