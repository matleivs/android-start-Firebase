/**
 * Copyright Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.firebase.codelab.friendlychat;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Service used to handle FCM logic.
 * Is used to alert the App when a new InstanceID token is generated
 * and to retrieve that generated token.
 *
 * We override the onTokenRefresh method in order to subscribe to a Topic.
 */
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

  private static final String TAG = "MyFirebaseIIDService";
  private static final String FRIENDLY_ENGAGE_TOPIC = "friendly_engage";

    /**
     * Use case: The Application's current Instance ID token is no longer valid
     * and thus a new one must be requested.
     *
     * The registration token may change when:

     The app deletes Instance ID
     The app is restored on a new device
     The user uninstalls/reinstall the app
     The user clears app data.
     */
    @Override
    public void onTokenRefresh(){
        // When you need to handle the generation of a token, initially or after a Refresh,
        // this is where you should do that.
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "FCM Token: " + token);

        // Once a token is generated, we subscribe-to-Topic to the topic defined above
        FirebaseMessaging.getInstance().subscribeToTopic(FRIENDLY_ENGAGE_TOPIC);
    }


}
