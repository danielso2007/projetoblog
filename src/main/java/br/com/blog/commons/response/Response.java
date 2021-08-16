package br.com.blog.commons.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Response<T> {

	private T data;
	private List<String> errors = new ArrayList<>();

	public Response() {
	}

	public Response(T data, List<String> errors) {
		this.data = data;
		this.errors = errors;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Response<T> data(T data) {
		setData(data);
		return this;
	}

	public Response<T> errors(List<String> errors) {
		setErrors(errors);
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, errors);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Response)) {
			return false;
		}
		Response<T> other = (Response<T>) obj;
		return Objects.equals(data, other.data) && Objects.equals(errors, other.errors);
	}

	@Override
	public String toString() {
		return "Response [" + (data != null ? "data=" + data + ", " : "") + (errors != null ? "errors=" + errors : "")
				+ "]";
	}

}
