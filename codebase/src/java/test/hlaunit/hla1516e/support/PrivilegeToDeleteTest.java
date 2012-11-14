/*
 *   Copyright 2012 The Portico Project
 *
 *   This file is part of portico.
 *
 *   portico is free software; you can redistribute it and/or modify
 *   it under the terms of the Common Developer and Distribution License (CDDL) 
 *   as published by Sun Microsystems. For more information see the LICENSE file.
 *   
 *   Use of this software is strictly AT YOUR OWN RISK!!!
 *   If something bad happens you do not have permission to come crying to me.
 *   (that goes for your lawyer as well)
 *
 */
package hlaunit.hla1516e.support;

import hla.rti1516e.ObjectClassHandle;
import hlaunit.hla1516e.common.Abstract1516eTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(sequential=true, groups={"PrivilegeToDeleteTest", "model"})
public class PrivilegeToDeleteTest extends Abstract1516eTest
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	@BeforeClass(alwaysRun=true)
	public void beforeClass()
	{
		super.beforeClass();

		// create a federation that we can test with //
		defaultFederate.quickCreate();
		defaultFederate.quickJoin();
	}
	
	@Override
	@AfterClass(alwaysRun=true)
	public void afterClass()
	{
		// destroy the federation that we are working in //
		defaultFederate.quickDestroy();

		super.afterClass();
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod()
	{
		defaultFederate.quickResign();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////// Test Methods //////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////
	// TEST: testPrivToDelete() //
	//////////////////////////////
	/**
	 * Added in response to PORT-349. Just try and obtain privilegeToDelete
	 */
	public void testPrivToDelete()
	{
		try
		{
			ObjectClassHandle oRoot = defaultFederate.rtiamb.getObjectClassHandle( "ObjectRoot" );
			defaultFederate.rtiamb.getAttributeHandle( oRoot, "HLAprivilegeToDelete" );
		}
		catch( Exception e )
		{
			Assert.fail( "Exception while fetching privilegeToDelete handle: "+e.getMessage(), e );
		}
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}