/*
 * Copyright (C) 2021 The Android Open Source Project.
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
package com.example.lunchtray.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lunchtray.data.DataSource
import java.text.NumberFormat

class OrderViewModel : ViewModel() {

    // Map of menu items
    val menuItems = DataSource.menuItems

    // Default values for item prices
    private var previousEntreePrice = 0.0
    private var previousSidePrice = 0.0
    private var previousAccompanimentPrice = 0.0

    // Default tax rate
    private val taxRate = 0.08

    // Entree for the order
    private val _entree = MutableLiveData<MenuItem?>()
    val entree: LiveData<MenuItem?> = _entree

    // Side for the order
    private val _side = MutableLiveData<MenuItem?>()
    val side: LiveData<MenuItem?> = _side

    // Accompaniment for the order.
    private val _accompaniment = MutableLiveData<MenuItem?>()
    val accompaniment: LiveData<MenuItem?> = _accompaniment

    // Subtotal for the order
    private val _subtotal = MutableLiveData(0.0)
    val subtotal: LiveData<String> = Transformations.map(_subtotal) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    // Total cost of the order
    private val _total = MutableLiveData(0.0)
    val total: LiveData<String> = Transformations.map(_total) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    // Tax for the order
    private val _tax = MutableLiveData(0.0)
    val tax: LiveData<String> = Transformations.map(_tax) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    /**
     * Set the entree for the order.
     */
    fun setEntree(entree: String) {
        // Track the price of the previously selected entree
        _entree.value?.let { previousEntreePrice = it.price }
        // Subtract the previously selected entree from the subtotal
        _subtotal.value = _subtotal.value?.minus(previousEntreePrice)
        // Set the current entree to the string passed
        _entree.value = DataSource.menuItems[entree]
        // Update the subtotal to reflect the side of the selected price
        updateSubtotal(_entree.value!!.price)
    }

    /**
     * Set the side for the order.
     */
    fun setSide(side: String) {
        // Track the price of the previously selected side
        _side.value?.let { previousSidePrice = it.price }
        // Subtract the previously selected side from the subtotal
        _subtotal.value = _subtotal.value?.minus(previousSidePrice)
        // Set the current side to the string passed
        _side.value = DataSource.menuItems[side]
        // Update the subtotal to reflect the price of the selected side
        updateSubtotal(_side.value!!.price)
    }

    /**
     * Set the accompaniment for the order.
     */
    fun setAccompaniment(accompaniment: String) {
        // Track the price of the previously selected accompaniment
        _accompaniment.value?.let { previousAccompanimentPrice = it.price }
        // Subtract the previously selected accompaniment from the subtotal
        _subtotal.value = _subtotal.value?.minus(previousAccompanimentPrice)
        // Set the current accompaniment to the string passed
        _accompaniment.value = DataSource.menuItems[accompaniment]
        // Update the current subtotal to reflect the price of the selected accompaniment
        updateSubtotal(_accompaniment.value!!.price)
    }

    /**
     * Update subtotal value.
     */
    private fun updateSubtotal(itemPrice: Double) {
        _subtotal.value = (_subtotal.value ?: 0.0) + itemPrice
        calculateTaxAndTotal()
    }

    /**
     * Calculate tax and update total.
     */
    fun calculateTaxAndTotal() {
        _subtotal.value?.let {
            _tax.value = it * taxRate
            _total.value = _tax.value!! + it
        }
    }

    /**
     * Reset all values pertaining to the order.
     */
    fun resetOrder() {
        _entree.value = null
        _side.value = null
        _accompaniment.value = null

        previousEntreePrice = 0.0
        previousSidePrice = 0.0
        previousAccompanimentPrice = 0.0

        _subtotal.value = 0.0
        _total.value = 0.0
        _tax.value = 0.0
    }
}
