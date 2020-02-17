package com.example.fragments

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_item_detail.*

/**
 * Una actividad que representa una pantalla de detalles de un solo artículo. Este
 * la actividad se utiliza sólo en dispositivos de ancho reducido. En dispositivos del tamaño de una tableta,
 * Los detalles de los artículos se presentan junto con una lista de artículos...
 * en una [Actividad de la Lista de Artículos].
 */
class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // Mostrar el botón Arriba en la barra de acción.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState es no nulo cuando hay estado de fragmentación
        // guardado de configuraciones previas de esta actividad
        // (por ejemplo, cuando se rota la pantalla de retrato a paisaje).
        // En este caso, el fragmento se volverá a añadir automáticamente
        // a su contenedor para que no tengamos que añadirlo manualmente.
        // Para más información, vea la guía de la API de Fragmentos en
        //

        Traducción realizada con la versión gratuita del traductor www.DeepL.com/Translator
        //
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        ItemDetailFragment.ARG_ITEM_ID,
                        intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // Esta identificación representa el botón de Inicio o Arriba. En el caso de este
                // actividad, se muestra el botón Arriba. Para
                // más detalles, ver el patrón de navegación en Diseño de Androides:
                //
                //

                navigateUpTo(Intent(this, ItemListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
