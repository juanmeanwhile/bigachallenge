/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.migration.endpoints.backend;

/*
Copyright 2017 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/



import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.endpoints.migration.example.com",
                ownerName = "backend.endpoints.migration.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name + "!");

        return response;
    }

    @ApiMethod(name = "getGoals", path= "goals")
    public CollectionResponse<Goal> getGoals() {
        List<Goal> ret = new ArrayList<>();
        ret.add(new Goal(1000, "Easy walk steps", "Walk 500 steps a day", Goal.TYPE_STEP, 500));
        ret.add(new Goal(1001, "Medium walk steps", "Walk 1000 steps a day", Goal.TYPE_STEP, 1000));
        ret.add(new Goal(1002, "Hard walk steps", "Walk 6000 steps a day", Goal.TYPE_STEP, 6000));
        ret.add(new Goal(1003, "Walk some distance", "Take a walk for 1 kilometer", Goal.TYPE_WALKING_DISTANCE, 1000));
        ret.add(new Goal(1004, "Quick Run", "Burn that donut by running 1 kilometer", Goal.TYPE_RUNNING_DISTANCE, 1000));
        ret.add(new Goal(1005, "Medium Run", "Zombie apocalypse may come any day soon, be prepared for the occasion", Goal.TYPE_RUNNING_DISTANCE, 5000));

        return CollectionResponse.<Goal> builder().setItems(ret)
                .setNextPageToken("not used").build();
    }

}
