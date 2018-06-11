# StarBazaar

Orbital 2018 Android Application.

Documentation: (Completed)
	
	LoginPage:

		- Fully scripted with basic functionality (working buttons etc..)

		- To link button to activities once other pages are complete.

	HeaderFragment: (Custom header for the application)

		- Any activity that needs to have a header must implement the HeaderFragmentListener interface and implement the following methods: SetHeaderText(Textview headerText) & revertToPreviousPage().

		- SetHeaderText(Textview headerText)
			This method makes the Textview that is on the header avaialble to use. Just use the headerText.setText("Enter String here") method to set the text for the header.

		- revertToPreviousPage()
			This method requires you to implement the method that will open the previous activity and finish the current one. The code in this method is directly responsible for the behaviour of the backbutton in the interface.

		- Adding the Fragment Widget to any activity.
			All that needs to be done in the xml side is to implement the fragment widget, set the height to the specified value give in dimens.xml and width to match_parent.

	IndividualShopDetails:

		- Base scripting and functionality is complete. This activity is to be activated when the user clicks a particular shop that is participating in the event.

		- Further functionality can only be implemented once other pages are done.
