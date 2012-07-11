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

package com.atlassian.jira.rest.client.domain;

import com.atlassian.jira.rest.client.IdentifiedEntity;
import com.atlassian.jira.rest.client.NamedEntity;
import com.atlassian.jira.rest.client.internal.json.StandardOperation;
import com.atlassian.jira.rest.client.internal.json.FieldSchema;
import com.google.common.base.Objects;

import javax.annotation.Nullable;
import java.net.URI;
import java.util.Set;

/**
 * Contains information about field in IssueType.
 *
 * @since v1.0
 */
public class CreateIssueFieldInfo implements NamedEntity, IdentifiedEntity<String> {

	private final String id;
	private final boolean required;
	@Nullable
	private final String name;
	private final FieldSchema schema;
	private final Set<StandardOperation> operations;
	@Nullable
	private final Iterable<Object> allowedValues;
	@Nullable
	private final URI autoCompleteUri;


	public CreateIssueFieldInfo(String id, boolean required, @Nullable String name, FieldSchema schema,
			Set<StandardOperation> operations, 	@Nullable Iterable<Object> allowedValues, @Nullable URI autoCompleteUri) {
		this.id = id;
		this.required = required;
		this.name = name;
		this.schema = schema;
		this.operations = operations;
		this.allowedValues = allowedValues;
		this.autoCompleteUri = autoCompleteUri;
	}

	public String getId() {
		return id;
	}

	public boolean isRequired() {
		return required;
	}

	@Nullable
	public String getName() {
		return name;
	}

	public FieldSchema getSchema() {
		return schema;
	}

	public Set<StandardOperation> getOperations() {
		return operations;
	}

	@Nullable
	public Iterable<Object> getAllowedValues() {
		return allowedValues;
	}

	@Nullable
	public URI getAutoCompleteUri() {
		return autoCompleteUri;
	}

	/**
	 * Returns ToStringHelper with all fields inserted. Override this method to insert additional fields.
	 *
	 * @return ToStringHelper
	 */
	protected Objects.ToStringHelper getToStringHelper() {
		return Objects.toStringHelper(this).
				add("id", id).
				add("name", name).
				add("required", required).
				add("schema", schema).
				add("operations", operations).
				add("allowedValues", allowedValues).
				add("autoCompleteUri", autoCompleteUri);
	}

	@Override
	public String toString() {
		return getToStringHelper().toString();
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CreateIssueFieldInfo) {
			CreateIssueFieldInfo that = (CreateIssueFieldInfo) obj;
			return Objects.equal(this.id, that.id)
					&& Objects.equal(this.name, that.name)
					&& Objects.equal(this.required, that.required)
					&& Objects.equal(this.schema, that.schema)
					&& Objects.equal(this.operations, that.operations)
					&& Objects.equal(this.allowedValues, that.allowedValues)
					&& Objects.equal(this.autoCompleteUri, that.autoCompleteUri);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, name, required, schema, operations, allowedValues, autoCompleteUri);
	}
}
