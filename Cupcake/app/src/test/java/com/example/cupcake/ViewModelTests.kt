package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: OrderViewModel

    @Before
    fun setup() {
        viewModel = OrderViewModel()
    }

    @Test
    fun quantity_twelve_cupcakes() {
        viewModel.setQuantity(12)
        Assert.assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        viewModel.setQuantity(12)
        // Price is a LiveData that needs to be observed because the value is
        // retrieved through a Transformation. Not observing it may return null
        // when calling the getter.
        viewModel.price.observeForever {}
        Assert.assertEquals("$27.00", viewModel.price.value)
    }

    @Test
    fun not_same_day_twelve_cupcakes() {
        viewModel.setQuantity(12)
        viewModel.setDate(viewModel.dateOptions[1])
        viewModel.price.observeForever {}
        Assert.assertEquals("$24.00", viewModel.price.value)
    }
}
