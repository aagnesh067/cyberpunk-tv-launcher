HI this is a concise `README.md` that keeps the core details of this project

```markdown
# Cyberpunk TV Launcher 🌃

A lightweight, distraction-free Android TV launcher inspired by the Cyberpunk 2077 HUD aesthetic. Built in Kotlin for high contrast, clean visuals, and smooth D-pad remote navigation.

---

## ✨ Features

- **Cyberpunk HUD Aesthetic**: High-contrast, dark UI with sharp neon styling built for TV screens.
- **Minimalist & Fast**: Zero bloat, ads, or sponsored feeds.
- **Remote-First**: Optimized for seamless navigation using standard Android TV remotes.

---

## 🛠️ Build & Install

1. **Clone & Open:**
   ```bash
   git clone [https://github.com/aagnesh067/cyberpunk-tv-launcher.git](https://github.com/aagnesh067/cyberpunk-tv-launcher.git)

```

Open the project in Android Studio and let Gradle sync.

2. **Deploy via ADB:**
```bash
adb connect <YOUR_TV_IP>:5555
./gradlew assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk

```


3. **Set as Default:**
Press the **Home** button on your TV remote and choose **Cyberpunk TV Launcher** as "Always".

---

## 🙏 Acknowledgements & Credits

Loosely based on and inspired by [tv-detox](https://github.com/Ansub/tv-detox) by **Ansub** — huge thanks for the foundation and inspiration toward minimalist TV experiences.

---

## 📄 License

This project is licensed under the MIT License.

```

```
