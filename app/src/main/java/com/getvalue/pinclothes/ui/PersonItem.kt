package com.getvalue.pinclothes.ui

import android.view.View
import com.getvalue.pinclothes.R
import com.getvalue.pinclothes.data.model.PersonItem
import com.getvalue.pinclothes.databinding.PersonListItemBinding
import com.xwray.groupie.viewbinding.BindableItem

/**
 * Created by Uwais Alqadri on August 11, 2021
 */
class PersonItem(
	private val person: PersonItem,
	private val onClick: (PersonItem) -> Unit
): BindableItem<PersonListItemBinding>() {
	override fun bind(viewBinding: PersonListItemBinding, position: Int) {
		viewBinding.apply {
			tvPerson.text = person.firstName

			root.setOnClickListener {
				onClick(person)
			}
		}
	}

	override fun getLayout(): Int = R.layout.person_list_item

	override fun initializeViewBinding(view: View): PersonListItemBinding {
		return PersonListItemBinding.bind(view)
	}
}