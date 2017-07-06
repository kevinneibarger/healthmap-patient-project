/**
 * 
 */
package com.liferay.healthmap.util;

import com.liferay.patient.registration.model.PatientRegistration;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author kneibarger
 *
 */
public class PatientInfoComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;
	
	public static String FIRST_NAME_SORT = "firstName";
	public static String LAST_NAME_SORT = "lastName";
	public String sortColumn = null;
	public boolean isAscOrder = false;
	
	public PatientInfoComparator(String sortCol, boolean isAscOrder) {
		this.sortColumn = sortCol;
		this.isAscOrder = isAscOrder;
	}
	
	
	@Override
	public int compare(Object p1, Object p2) {
		
		PatientRegistration patient1 = (PatientRegistration)p1;
		PatientRegistration patient2 = (PatientRegistration)p2;
	
		if (this.sortColumn != null && this.sortColumn.equalsIgnoreCase(FIRST_NAME_SORT)) {
			// Sorting the column by Ascending Order
			if (this.isAscOrder) {
				return patient1.getFirstName().toLowerCase().compareTo(patient2.getFirstName().toLowerCase());
			} else { // Sorting the column by Descending Order
				return patient2.getFirstName().toLowerCase().compareTo(patient1.getFirstName().toLowerCase());
			}
			
		} else if (this.sortColumn != null && this.sortColumn.equalsIgnoreCase(LAST_NAME_SORT)) {
			if (this.isAscOrder) {
				return patient1.getLastName().toLowerCase().compareTo(patient2.getLastName().toLowerCase());
			} else {
				return patient2.getLastName().toLowerCase().compareTo(patient1.getLastName().toLowerCase());
			}
		}
		
		return -1;
	}

}
