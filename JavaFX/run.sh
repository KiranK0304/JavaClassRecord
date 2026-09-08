#!/usr/bin/env bash
set -e

# Load JavaFX environment if not already set
if [ -z "$PATH_TO_FX" ]; then
    if [ -f "$HOME/.bashrc" ]; then
        source "$HOME/.bashrc"
    fi
fi

# Fallback if PATH_TO_FX is still unset
PATH_TO_FX="${PATH_TO_FX:-$HOME/.local/share/openjfx/current/lib}"

echo "Compiling Main.java..."
javac --module-path "$PATH_TO_FX" --add-modules javafx.controls Main.java

echo "Launching JavaFX Application..."
java --module-path "$PATH_TO_FX" --add-modules javafx.controls --enable-native-access=javafx.graphics Main
