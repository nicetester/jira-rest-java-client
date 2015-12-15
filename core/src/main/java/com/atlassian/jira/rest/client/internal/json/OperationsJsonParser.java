/*
 * Copyright (C) 2014 Atlassian
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.atlassian.jira.rest.client.internal.json;

import com.atlassian.jira.rest.client.api.domain.OperationGroup;
import com.atlassian.jira.rest.client.api.domain.Operations;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.util.Collection;

public class OperationsJsonParser implements JsonElementParser<Operations> {
    private final JsonElementParser<OperationGroup> groupParser = new OperationGroupJsonParser();

    @Override
    public Operations parse(final JsonElement jsonElement) throws JsonParseException {
        final JsonObject json = jsonElement.getAsJsonObject();

        final Collection<OperationGroup> linkGroups = JsonParseUtil.parseJsonArray(json.getAsJsonArray("linkGroups"), groupParser);
        return new Operations(linkGroups);
    }
}
