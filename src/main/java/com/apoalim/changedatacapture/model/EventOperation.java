/*
 author Anastasiya
 created on 29/08/2021
 */

package com.apoalim.changedatacapture.model;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public enum EventOperation implements Serializable {
    INSERT, UPDATE, DELETE
}
