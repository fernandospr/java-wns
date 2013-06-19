## Introduction

java-wns is a Java client for Windows Push Notification service (WNS).

This library will let you implement the Cloud Service of the diagram below:

<img src="http://i.msdn.microsoft.com/dynimg/IC554245.png"/>


## Steps
First, you will need to register your Windows application in the store.

Second, obtain the channel uri of your devices.

Third, use this library to authenticate with WNS and send the notifications!


### First step - Registration
Go to the Windows Store app development page of the Windows Dev Center and sign in with your Microsoft account.

Once you have signed in, select the Dashboard tab.

On the Dashboard, submit your Windows app and update your package.appxmanifest with the corresponding identity values.

Go to Services>Push notifications and Live Connect services info and below "If your app uses WNS for push notifications, review", select Authenticating yor service.

Save the SID (Package security identifier) and client secret.



### Second step - Obtain channel uri


### Third step - Send notifications


## Links
This library was built based on the following Microsoft documentation:

Overview: http://msdn.microsoft.com/en-us/library/windows/apps/hh913756.aspx

Sending push notifications: http://msdn.microsoft.com/en-us/library/windows/apps/hh465460.aspx

Schemas: http://msdn.microsoft.com/en-us/library/windows/apps/br212853.aspx

Toast templates: http://msdn.microsoft.com/en-us/library/windows/apps/hh761494.aspx

Toast audio options: http://msdn.microsoft.com/en-us/library/windows/apps/hh761492.aspx

Tile templates: http://msdn.microsoft.com/en-us/library/windows/apps/hh761491.aspx
