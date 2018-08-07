package com.metroservice.schedule.exception;

public class ScheduleNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4288685436198496686L;
	private String resourceName;
	private String fieldName;
    private Object fieldValue;
	 public ScheduleNotFoundException( String resourceName, String fieldName, Object fieldValue) {
	        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
	        this.resourceName = resourceName;
	        this.fieldName = fieldName;
	        this.fieldValue = fieldValue;
	    }
	 public String getResourceName() {
			return resourceName;
		}
		public void setResourceName(String resourceName) {
			this.resourceName = resourceName;
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public Object getFieldValue() {
			return fieldValue;
		}
		public void setFieldValue(Object fieldValue) {
			this.fieldValue = fieldValue;
		}

}
