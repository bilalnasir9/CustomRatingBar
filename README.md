# ⭐ CustomRatingBar

A fully‑customizable, lightweight `RatingBar` replacement for Android, written in Kotlin.

Easily use vector drawables, control step size (0.5 / 0.25 / …), swap icons at runtime, and handle user rating changes with a clean API.

[![](https://jitpack.io/v/bilalnasir9/CustomRatingBar.svg)](https://jitpack.io/#bilalnasir9/CustomRatingBar)

---

## 🚀 Features

- ✅ Vector drawable support (SVG‑friendly)
- ✅ Partial ratings via `stepSize`
- ✅ Runtime icon swap (`setIcons()`)
- ✅ Read‑only mode (`isIndicator = true`)
- ✅ RTL + TalkBack ready
- ✅ Tiny (~60 KB AAR, minified)

---

## 📦 Installation

CustomRatingBar is on **JitPack**.  
Pick the snippet that matches your build setup and replace **`YOUR_GITHUB_USERNAME`** with your own handle.

### Kotlin DSL (`build.gradle.kts`)

1. Root `settings.gradle.kts`

~~~kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
~~~

2. Module `build.gradle.kts`

~~~kotlin
dependencies {
    implementation("com.github.YOUR_GITHUB_USERNAME:custom-ratingbar:1.0.0")
}
~~~

---

### Groovy (`build.gradle`)

1. Root `build.gradle`

~~~groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}
~~~

2. App/module `build.gradle`

~~~groovy
dependencies {
    implementation 'com.github.YOUR_GITHUB_USERNAME:custom-ratingbar:1.0.0'
}
~~~

---

## 🧩 Usage

### XML

~~~xml
<com.bilal.customratingbar.CustomRatingBar
    android:id="@+id/ratingBar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:maxRating="5"
    app:rating="3.5"
    app:stepSize="0.5"
    app:isIndicator="false" />
~~~

### Kotlin / Java

~~~kotlin
// Set or read values
ratingBar.rating      = 4.0f
ratingBar.stepSize    = 0.5f
ratingBar.maxRating   = 5
ratingBar.isIndicator = false

// Listen for user changes
ratingBar.onRatingChanged = { value, fromUser ->
    if (fromUser) {
        Toast.makeText(this, "User picked $value stars", Toast.LENGTH_SHORT).show()
    }
}

// Swap icons at runtime (optional)
ratingBar.setIcons(
    filled = R.drawable.ic_crb_star_filled,
    empty  = R.drawable.ic_crb_star_empty,
    half   = R.drawable.ic_crb_star_half   // optional
)
~~~

If you skip `setIcons()`, built‑in yellow/gray star vectors are used automatically.

---

## 📘 Attribute & API Reference

| Attribute / Property | Type      | Default | Description                                 |
|----------------------|-----------|---------|---------------------------------------------|
| `rating`             | Float     | `0f`    | Current rating value                        |
| `maxRating`          | Int       | `5`     | Number of stars/icons                       |
| `stepSize`           | Float     | `1f`    | Smallest increment (e.g. `0.5`)             |
| `isIndicator`        | Boolean   | `false` | `true` → read‑only                          |
| `iconFilled`         | Drawable  | built‑in| Filled icon                                 |
| `iconEmpty`          | Drawable  | built‑in| Empty icon                                  |
| `iconHalf`           | Drawable  | built‑in| Half icon (optional)                        |
| `iconSize`           | Dimension | `48dp`  | Size of each icon                           |
| `iconPadding`        | Dimension | `0dp`   | Space between icons                         |
| `setIcons()`         | Function  | —       | Swap icons at runtime                       |
| `onRatingChanged`    | Listener  | —       | `(value: Float, fromUser: Boolean) -> Unit` |

---

## 🧪 Sample App

Clone and run the demo:

```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/custom-ratingbar.git
cd custom-ratingbar
./gradlew :sample:installDebug
