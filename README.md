# ⭐ CustomRatingBar

A fully customizable, lightweight RatingBar replacement for Android written in Kotlin.  
Easily use vector drawables, control step size (0.5, 1, etc.), switch icons at runtime, and handle user rating changes with clean MVVM-friendly APIs.

[![](https://jitpack.io/v/bilalnasir9/CustomRatingBar.svg)](https://jitpack.io/#bilalnasir9/CustomRatingBar)


## 🚀 Features

✅ Vector drawable support (SVG-friendly)  
✅ Half / partial star ratings (stepSize = 0.5f)  
✅ Runtime icon swap (setIcons(...))  
✅ RTL support out of the box  
✅ Touch interaction or read-only mode  
✅ Fully themeable and lightweight (~60KB AAR)


## 📦 Installation

Add JitPack to your build.gradle (project level) or settings.gradle


allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}


```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
