# Brief Use Cases

### Rate class
 - System asks which class to rate (gives a few options)
 - User picks course
 - Rates course based on a "5-Star" scale
 - System saves rating
 - Displays course rating on profile
### Update edu.vassar.cmpu203.schmoodleproto1.Model.Profile
 - User selects a fields of their profile (ie. name, major, pronouns, courses taken, clubs)
 - User inputs the information in the dialog box
 - System saves updated field
 - System displays new data on profile

### Delete edu.vassar.cmpu203.schmoodleproto1.Model.Dashboard edu.vassar.cmpu203.schmoodleproto1.Model.Event
 - System asks if user is deleting or adding an event
 - User selects 'delete event'
 - System erases event
 - System updates the dashboard
//^^ this is no longer how our app works ^^//
   
### Add edu.vassar.cmpu203.schmoodleproto1.Model.Dashboard edu.vassar.cmpu203.schmoodleproto1.Model.Event
 - System asks if user is deleting or adding an event
 - User selects 'add event'
 - User inputs event info in dialog box
 - System saves new event
 - System updates the dashboard
### Log-out
 - User selects 'log-out' button
 - System logs user out of the app 
 - System returns to sign-in home page
### Search Profiles and Dashboards
 - User types in name of another user/dashboard in dialogue box
 - System validates if user/dashboard exists
 - System returns the user/dashboard if valid
 - User selects on a user/dashboard from list of results
 - System shows profile of selected user
### DM a Specific edu.vassar.cmpu203.schmoodleproto1.Model.Profile
 - User selects 'DM' button.
 - System returns a dialogue box with message 'search friends
 - User inputs desired user
 - System validates user and returns a chat room
 - User inputs message in dialogue box
 - User directly messages another user in a private messaging room
 - System displays message on right side of chat room
### Get Recommendation 
 - System matches users based on similar major, classes taken, and club Strings
 - System returns a list of other users with matching fields
### Validate PIN 
 - System checks if PIN input is a 4-digit number 
 - System allows submission to continue if it is. 
 - If not, the system flashes an error message and 
takes user back to the Create edu.vassar.cmpu203.schmoodleproto1.Model.Dashboard screen.