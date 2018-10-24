# VDAB App Dynamics Node
### Overview 
This node allows pushing VDAB data directly into the AppDynamics metric database.

| | |
|  --- |  :---: |
| Application Page    | NA |
| Demo Web Link   |  NA |

### Features
<ul>
<li>Allows storage of VDAB event data in the AppDynamics metric database.
<li>The <i>AppDynService</i> pushes VDAB event data into AppDynamics.
</ul>

### Loading the the Package
The current or standard version can be loaded directly using the VDAB Android Client following the directions
for [Adding Packages](https://vdabtec.com/vdab/docs/VDABGUIDE_AddingPackages.pdf) 
and selecting the <i>AppDynNodes</i> package.
 
A custom version can be built using Gradle following the direction below.

* Clone or Download this project from Github.
* Open a command windows from the <i>AppDynNodes</i> directory.
* Build using Gradle: <pre>      gradle vdabPackage</pre>

This builds a package zip file which contains the components that need to be deployed. These can be deployed by 
manually unzipping these files as detailed in the [Server Updates](https://vdabtec.com/vdab/docs/VDABGUIDE_ServerUpdates.pdf) 
 documentation.

### Known Issues as of 24 Oct  2018

* Limited capabilities.


