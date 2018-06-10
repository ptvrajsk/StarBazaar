# StarBazaar

Orbital 2018 Android Application.

Documentation:

 HeaderFragment
    When implementing HeaderFragment into activity, ensure that the java class tied to the particular activity has implemented the HeaderFragmentListener interface. The overwridden methods are setHeaderText(Textview ..), where the text for the header has to be set (It is to describe to the user the activity he/she is in), and revertToPreviousPage(), where we need to create a method that would launch the previous activity and kill the current one. This method is directly responsible
    for the functionality of the back button in the interface. 
