/*
 * Copyright (C) 2012 Atlassian
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

import com.atlassian.jira.rest.client.api.domain.CimProject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * JSON parser for REST action issue/createmeta result
 *
 * @since v1.0
 */
public class CreateIssueMetadataJsonParser implements JsonElementParser<Iterable<CimProject>> {

    private final GenericJsonArrayParser<CimProject> projectsParser = new GenericJsonArrayParser<CimProject>(new CimProjectJsonParser());

    @Override
    public Iterable<CimProject> parse(final JsonElement jsonElement) throws JsonParseException {
        final JsonObject json = jsonElement.getAsJsonObject();

        return projectsParser.parse(json.get("projects").getAsJsonArray());
    }
}
