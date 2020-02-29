package com.green.screw.java.errors;

import java.util.List;

import org.springframework.data.mapping.PropertyPath;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.data.util.TypeInformation;

public class ScrewServerException extends PropertyReferenceException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -659145833196250171L;

	public ScrewServerException(String propertyName, TypeInformation<?> type, List<PropertyPath> alreadyResolvedPah) {
		super(propertyName, type, alreadyResolvedPah);

		// TODO Auto-generated constructor stub
	}



}
