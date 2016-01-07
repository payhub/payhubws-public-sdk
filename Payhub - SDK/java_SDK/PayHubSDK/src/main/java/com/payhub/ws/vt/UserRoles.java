package com.payhub.ws.vt;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserRoles {
	
		public final static String ALL_USER_ROLE_LINK="userRole/roles";
		public ArrayList<Roles> userRoles;
		
		public UserRoles(){}
		
		
		/**
		 * @return the userRoles
		 */
		public ArrayList<Roles> getUserRoles() {
			return userRoles;
		}

		/**
		 * @param userRoles the userRoles to set
		 */
		public void setUserRoles(ArrayList<Roles> userRoles) {
			this.userRoles = userRoles;
		}


		public static class Roles{
			
			public String numberOfUsers;
			public String roleName;
			public String roleId;
			
			public Roles() {
			}
			/**
			 * @return the numberOfUsers
			 */
			public String getNumberOfUsers() {
				return numberOfUsers;
			}
			/**
			 * @param numberOfUsers the numberOfUsers to set
			 */
			public void setNumberOfUsers(String numberOfUsers) {
				this.numberOfUsers = numberOfUsers;
			}
			/**
			 * @return the roleName
			 */
			public String getRoleName() {
				return roleName;
			}
			/**
			 * @param roleName the roleName to set
			 */
			public void setRoleName(String roleName) {
				this.roleName = roleName;
			}
			/**
			 * @return the roleId
			 */
			public String getRoleId() {
				return roleId;
			}
			/**
			 * @param roleId the roleId to set
			 */
			public void setRoleId(String roleId) {
				this.roleId = roleId;
			}
			
			
		}
		
}
