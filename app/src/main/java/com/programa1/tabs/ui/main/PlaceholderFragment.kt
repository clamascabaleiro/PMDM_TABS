package com.programa1.tabs.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.programa1.tabs.R

/**
 * Un modelo de creación de Fragment que contiene un View sencillo
 */

class PlaceholderFragment : Fragment() {

    /**
     * Variable para utilizar la clase PageViewModel
     */

    private lateinit var pageViewModel: PageViewModel

    /**
     * Especifica el ViewModel llamando a la clase PageViewModel
     * utilizando la función setIndex de la misma clase
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1) // Utiliza el setIndex de la misma clase
        }
    }

    /**
     * Le asigna un TextView al layout llamado fragment_main.xml
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        pageViewModel.text.observe(this, Observer<String> {
            textView.text = it
        })
        return root
    }

    companion object {
        /**
         *
         * El argumento del Fragment representa el número de sección para ese fragment
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         *
         * Devuelve una nueva instancia de ese fragmento para el número de sección especificado
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
