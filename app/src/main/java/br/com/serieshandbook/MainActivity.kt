package br.com.serieshandbook

import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navView: NavigationView
    private lateinit var toolbarLayout: AppBarLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navBottomView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        navView = findViewById(R.id.nav_view)
        navBottomView = findViewById(R.id.nav_bottom_view)
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbarLayout = findViewById<AppBarLayout>(R.id.toolbar_layout)
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.homeFragment,
                    R.id.homeFragmentMovie,
                    R.id.homeFragmentSeries,
                    R.id.historicoFragment,
                    R.id.laterFragment,
                ), drawerLayout
        )
        // aparecer o icone de estrela
        setSupportActionBar(toolbar)
        // aparecer o titulo de acordo com a janela
        toolbar.setupWithNavController(navController, appBarConfiguration)
        //aparecer o bottom menu
        navBottomView.setupWithNavController(navController)
        //aparecer o drawer
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }
}