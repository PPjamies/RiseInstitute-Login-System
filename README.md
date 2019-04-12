# RiseInstitute-SignInSheet

ADMINISTRATOR OF THE DIGITAL SIGN-IN SHEET

	How The Pieces Are Connected:
	
		-Java GUI is connected to ms access through Jackcess JAR File, Jackcess Logger and Loggin packages.
		-This is due SQL database manager not being supported by ms access anymore.
		-To learn how to read and write to table in ms access using Jackcess, please look to the Jackcess API and examples available on the Jackcess website.
	
	How To Manage The Digital Sign-in Sheet:
	
		-DO NOT MANUALLY DELETE USER ENTRIES DIRECTLY FROM THE TABLE, this will cause the index (auto-number increment) to be disalign with
			the binding that happens behind the scenes with Jackcess, causing the entire system to work incorrectly.
			The Error message which indicates this issue will look something like this: "Cannot cast string to int" 
			To resolve this issue in the case it happens, you will need to delete the whole relational_signin table, recreate it, and importing backup data from
			the sharepoint to the new table.
			Another solution is manually copying all the column entries from the corrupted table (besides the indexing), deleting the table, then reacreating the table 
			and pasting all the entries back in.
			
		-ACCESS 2007 DOES NOT SUPPORT AUTO-EXPORTING TO SHAREPOINT, so don't waste your time trying unless you upgraded to the 2016 version (or higher).
			You will need to manually export the data to the shairpoint.
		
		-ACCESS SUPPORTS SQL QUERIES. Three queries have already been built, but you can build as much as you want.
		
		
	How To Launch The Digital Sign-in Sheet Cleanly Through The Command Line:
		
		-
