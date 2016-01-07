package com.payhub.ws.vt;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GeneralSettings {
	
		public final static String GENERAL_SETTINGS_LINK="adminSettings/generalSettings";
		private String inactivityHour;
		private ArrayList<TerminalList> terminalList;
		
		public GeneralSettings(){}

		/**
		 * @return the inactivityHour
		 */
		public String getInactivityHour() {
			return inactivityHour;
		}

		/**
		 * @param inactivityHour the inactivityHour to set
		 */
		public void setInactivityHour(String inactivityHour) {
			this.inactivityHour = inactivityHour;
		}

		/**
		 * @return the terminalList
		 */
		public ArrayList<TerminalList> getTerminalList() {
			return terminalList;
		}

		/**
		 * @param terminalList the terminalList to set
		 */
		public void setTerminalList(ArrayList<TerminalList> terminalList) {
			this.terminalList = terminalList;
		}
		
		public static class TerminalList{
			private String nickName;
			private String terminalType;
			private String settlementTime;
			
			public TerminalList(){}

			/**
			 * @return the nickName
			 */
			public String getNickName() {
				return nickName;
			}

			/**
			 * @param nickName the nickName to set
			 */
			public void setNickName(String nickName) {
				this.nickName = nickName;
			}

			/**
			 * @return the terminalType
			 */
			public String getTerminalType() {
				return terminalType;
			}

			/**
			 * @param terminalType the terminalType to set
			 */
			public void setTerminalType(String terminalType) {
				this.terminalType = terminalType;
			}

			/**
			 * @return the settlementTime
			 */
			public String getSettlementTime() {
				return settlementTime;
			}

			/**
			 * @param settlementTime the settlementTime to set
			 */
			public void setSettlementTime(String settlementTime) {
				this.settlementTime = settlementTime;
			}
			
			
		}
		
		public String toString(){
			ObjectMapper mapper = new ObjectMapper();
	        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	        String jsonInString;
			try {
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
				return jsonInString;
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				return null;
			}
	        
		}
}
