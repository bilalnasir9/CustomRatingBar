# ⭐ CustomRatingBar

A fully‑customizable, lightweight `RatingBar` replacement for Android, written in Kotlin.

Easily use vector drawables, control step size (0.5 / 1), swap icons at runtime, and handle user rating changes with a clean API.

[![](https://jitpack.io/v/bilalnasir9/CustomRatingBar.svg)](https://jitpack.io/#bilalnasir9/CustomRatingBar)

---

## 🚀 Features

- ✅ Vector drawable support (SVG‑friendly)
- ✅ Partial ratings via `stepSize`
- ✅ Runtime icon swap (`setIcons()`)
- ✅ Read‑only mode (`isReadOnly = true`)
- ✅ RTL + TalkBack ready
- ✅ Tiny (~60 KB AAR, minified)

---

## 📦 Installation

CustomRatingBar is on **JitPack**.  
Pick the snippet that matches your build setup:

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
	 implementation("com.github.bilalnasir9:CustomRatingBar:1.0.0")
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
	   implementation 'com.github.bilalnasir9:CustomRatingBar:1.0.0'
}
~~~

---

## 🧩 Usage

### XML

~~~xml
<com.github.bilalnasir9.library.ratingbar.CustomRatingBar
        android:id="@+id/ratingBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        app:iconEmpty="@drawable/ic_star_empty"
        app:iconFilled="@drawable/ic_star_filled"
        app:iconHalf="@drawable/ic_star_half"
        app:iconSize="40dp"
        app:stepSize="0.5"
        app:readOnly="false"
        app:iconPadding="8dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:maxRating="5"
        app:rating="3" />
~~~

### Kotlin / Java

~~~kotlin
// Set or read values
ratingBar.rating      = 4.0f
ratingBar.stepSize    = 0.5f
ratingBar.maxRating   = 5
ratingBar.isReadOnly = false

// Listen for user changes
ratingBar.setOnRatingBarChangeListener = { newRating ->
                Log.d("TAG", "Rating: $newRating")
        }

// Swap icons at runtime (optional)
ratingBar.setIcons(
    filled = R.drawable.ic_star_filled,
    empty  = R.drawable.ic_star_empty,
    half   = R.drawable.ic_star_half   // optional
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
| `isReadOnly`        | Boolean   | `false` | `true` → read‑only                          |
| `iconFilled`         | Drawable  | built‑in| Filled icon                                 |
| `iconEmpty`          | Drawable  | built‑in| Empty icon                                  |
| `iconHalf`           | Drawable  | built‑in| Half icon (optional)                        |
| `iconSize`           | Dimension | `48dp`  | Size of each icon                           |
| `iconPadding`        | Dimension | `0dp`   | Space between icons                         |
| `setIcons()`         | Function  | —       | Swap icons at runtime                       |
| `onRatingChanged`    | Listener  | —       | `(value: Float, fromUser: Boolean) -> Unit` |

---

## 🙋‍♂️ About Me

- 🧑‍💻 GitHub: [@bilalnasir9](https://github.com/bilalnasir9)  
- 📧 Email: [bilalnasir6860@gmail.com](mailto:bilalnasir6860@gmail.com)

Feel free to reach out, contribute, or suggest improvements.

