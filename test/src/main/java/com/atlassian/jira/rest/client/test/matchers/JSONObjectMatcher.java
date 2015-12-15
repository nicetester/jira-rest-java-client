/*
 * Copyright (C) 2011 Atlassian
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

package com.atlassian.jira.rest.client.test.matchers;

import com.google.gson.JsonObject;
import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class JSONObjectMatcher extends TypeSafeMatcher<JsonObject> {

    private final JsonObject jsonObject;

    public JSONObjectMatcher(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public static JSONObjectMatcher isEqual(JsonObject jsonObject) {
        return new JSONObjectMatcher(jsonObject);
    }

    @Override
    public boolean matchesSafely(JsonObject item) {
        return item.toString().equals(jsonObject.toString());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("JsonObject " + jsonObject.toString());
    }
}
