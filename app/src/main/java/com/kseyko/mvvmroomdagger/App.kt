package com.kseyko.mvvmroomdagger

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      07,February,2021      ║
╚════════════════════════════╝
 */
@HiltAndroidApp //All apps that use Hilt must contain an Application class that is annotated with @HiltAndroidApp.
//triggers Hilt's code generation, including a base class for your application that serves as the application-level dependency container.
class App :
    Application() //This generated Hilt component is attached to the Application object's lifecycle and provides dependencies to it.
// Additionally, it is the parent component of the app, which means that other components can access the dependencies that it provides.