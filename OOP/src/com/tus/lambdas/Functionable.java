package com.tus.lambdas;

public interface Functionable<T, R> {

	R applyThis(T t);
}
