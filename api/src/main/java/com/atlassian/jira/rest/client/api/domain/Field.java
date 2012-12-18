package com.atlassian.jira.rest.client.api.domain;

import com.atlassian.jira.rest.client.api.IdentifiableEntity;
import com.atlassian.jira.rest.client.api.NamedEntity;
import com.google.common.base.Objects;

import javax.annotation.Nullable;

/**
 * TODO: Document this class / interface here
 *
 * @since v6.0
 */
public class Field implements NamedEntity, IdentifiableEntity<String> {

	private final String id;
	private final String name;
	private final FieldType custom;
	private final Boolean orderable;
	private final Boolean navigable;
	private final Boolean searchable;
	@Nullable
	private final FieldSchema schema;

	public Field(String id, String name, FieldType custom, Boolean orderable, Boolean navigable, Boolean searchable, FieldSchema schema) {

		this.id = id;
		this.name = name;
		this.custom = custom;
		this.orderable = orderable;
		this.navigable = navigable;
		this.searchable = searchable;
		this.schema = schema;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public FieldType getCustom() {
		return custom;
	}

	public Boolean getOrderable() {
		return orderable;
	}

	public Boolean getNavigable() {
		return navigable;
	}

	public Boolean getSearchable() {
		return searchable;
	}

	@Nullable
	public FieldSchema getSchema() {
		return schema;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, name, custom, orderable, navigable, searchable, schema);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Field) {
			final Field that = (Field) obj;
			return Objects.equal(this.id, that.id)
					&& Objects.equal(this.name, that.name)
					&& Objects.equal(this.custom, that.custom)
					&& Objects.equal(this.orderable, that.orderable)
					&& Objects.equal(this.navigable, that.navigable)
					&& Objects.equal(this.searchable, that.searchable)
					&& Objects.equal(this.schema, that.schema);
		}
		return false;
	}

	protected Objects.ToStringHelper getToStringHelper() {
		return Objects.toStringHelper(this)
				.add("id", id)
				.add("name", name)
				.add("custom", custom)
				.add("orderable", orderable)
				.add("navigable", navigable)
				.add("searchable", searchable)
				.add("schema", schema);
	}

	@Override
	public String toString() {
		return getToStringHelper().toString();
	}
}