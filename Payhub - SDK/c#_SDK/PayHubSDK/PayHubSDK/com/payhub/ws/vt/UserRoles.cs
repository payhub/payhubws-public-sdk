using PayHubSDK.com.payhub.ws.util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
using PayHubSDK.com.payhub.ws.api;

namespace PayHubSDK.com.payhub.ws.vt
{
    [DataContract]
    public class UserRoles
    {
        public static string ALL_USER_ROLE_LINK="userRole/roles";

        [DataMember]
        public List<Roles> userRoles;
        [DataMember]
        public List<Errors> errors;

        [DataContract]
        public class Roles
        {
            [DataMember]
            public string numberOfUsers;
            [DataMember]
            public string roleName;
            [DataMember]
            public string roleId;
        }
    }
    
}
