## Introduction

java-wns is a Java client for Windows Push Notification service (WNS).

This library will let you implement the Cloud Service of the diagram below:

<img src="http://i.msdn.microsoft.com/dynimg/IC554245.png"/>


## Steps
First, you will need to register your Windows application in the store to get a SID (Package security identifier) and Client Secret codes.

Second, obtain the Channel URI of your devices.

Third, use this library to authenticate with WNS and send the notifications!


### First step - Registration
Go to the Windows Store app development page of the Windows Dev Center and sign in with your Microsoft account.

Once you have signed in, select the Dashboard tab.

On the Dashboard, submit your Windows app and update your package.appxmanifest with the corresponding identity values.

If you want your devices to receive Toast notifications, you should also change "Toast capable" to YES in the manifest configuration.

Go to Services>Push notifications and Live Connect services info and below "If your app uses WNS for push notifications, review", select Authenticating yor service.

Save the SID (Package security identifier) and Client Secret, example screenshot below:
<img src="http://i.msdn.microsoft.com/dynimg/IC582761.png"/>


### Second step - Obtain Channel URI

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

<a href="https://github.com/fernandospr/java-wns/wiki/Installation">Install this library</a> and write the following to start the service:

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


## Response headers
The pushXXX methods of WnsService return an object of the WnsNotificationResponse type. 
This object contains the values specified in the Headers (Send notification response section) in the Links section.


## Request optional headers
There are pushXXX methods implementations that receive an object of the WnsNotificationRequestOptional type.
You should create an object of this type and set the corresponding values, according to the Headers (Request parameters) in the Links Section.


## Links
This library was built based on the following Microsoft documentation:

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh913756.aspx">Overview</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465460.aspx">Sending push notifications</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/br212853.aspx">Schemas</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh761494.aspx">Toast templates</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh761492.aspx">Toast audio options</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh761491.aspx">Tile templates</a>

<a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx">Headers</a>


## License

Licensed under the [New 3-Clause BSD License](http://www.opensource.org/licenses/BSD-3-Clause).

    Copyright 2013, Fernando Sproviero.
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions are
    met:

      * Redistributions of source code must retain the above copyright
        notice, this list of conditions and the following disclaimer.
      * Redistributions in binary form must reproduce the above
        copyright notice, this list of conditions and the following disclaimer
        in the documentation and/or other materials provided with the
        distribution.
      * Neither the name of Fernando Sproviero nor the names of its
        contributors may be used to endorse or promote products derived from
        this software without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
    "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
    LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
    A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
    OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
    SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
    LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
    OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
