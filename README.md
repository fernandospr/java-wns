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

If you want your devices to receive Toast notifications, you should also change "Toast capable" to YES in the manifest configuration.

Go to Services>Push notifications and Live Connect services info and below "If your app uses WNS for push notifications, review", select Authenticating yor service.

Save the SID (Package security identifier) and client secret, example screenshot below:
<img src="http://i.msdn.microsoft.com/dynimg/IC582761.png"/>


### Second step - Obtain channel uri

Add the following code to your Windows app:

Javascript:
```
var channel;
var pushNotifications = Windows.Networking.PushNotifications;
var channelOperation = pushNotifications.PushNotificationChannelManager.createPushNotificationChannelForApplicationAsync();

return channelOperation.then(function (newChannel) {
    channel = newChannel;
    // Success. The channel URI is found in newChannel.uri.
    },
    function (error) {
        // Could not create a channel. Retrieve the error through error.number.
    }
);
```

C#
```
PushNotificationChannel channel = null;

try
{
    channel = await PushNotificationChannelManager.CreatePushNotificationChannelForApplicationAsync();
    // Success. The channel URI is found in channel.uri.
}

catch (Exception ex)
{ 
    // Could not create a channel. 
}
```


### Third step - Send notifications
Now with your SID, Client Secret and Channel URI you are ready to send!

Using this library, write the following to start the service:

```
boolean logging = true;
String sid = "yourSID";
String clientSecret = "yourClientSecret";
WnsService service = new WnsService(sid, clientSecret, logging);
```

Write the following to send a Badge:
```
String channelUri = "yourChannelUri";
WnsBadge badge =  new WnsBadgeBuilder().value(1).build();
service.pushBadge(channelUri, badge);
```

Write the following to send a Tile:
```
String channelUri = "yourChannelUri";
WnsTile tile =  new WnsTileBuilder.bindingTemplateTileWideText03("Hello world").build();
service.pushTile(channelUri, tile);
```

Write the following to send a Toast:
```
String channelUri = "yourChannelUri";
WnsToast toast =  new WnsToastBuilder.bindingTemplateToastText01("Hello world").build();
service.pushToast(channelUri, toast);
```


## Notification builders
To create and customize notifications, you should use the following builders:

* WnsBadgeBuilder
* WnsToastBuilder
* WnsTileBuilder

WnsToastBuilder and WnsTileBuilder have methods with the following signature:
```
bindingTemplateXXX()
```
Please check the Toast and Tile templates in the Links section to use the one you need.


## Links
This library was built based on the following Microsoft documentation:

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh913756.aspx">Overview</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465460.aspx">Sending push notifications</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/br212853.aspx">Schemas</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh761494.aspx">Toast templates</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh761492.aspx">Toast audio options</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh761491.aspx">Tile templates</a>
