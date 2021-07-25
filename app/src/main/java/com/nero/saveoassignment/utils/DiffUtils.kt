package com.nero.saveoassignment.utils

import androidx.recyclerview.widget.DiffUtil
import com.nero.saveoassignment.data.model.MovieResponseItem

class DiffUtils {

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<MovieResponseItem>() {
            override fun areItemsTheSame(
                oldItem: MovieResponseItem,
                newItem: MovieResponseItem
            ): Boolean {
                return newItem == oldItem
            }

            override fun areContentsTheSame(
                oldItem: MovieResponseItem,
                newItem: MovieResponseItem
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}