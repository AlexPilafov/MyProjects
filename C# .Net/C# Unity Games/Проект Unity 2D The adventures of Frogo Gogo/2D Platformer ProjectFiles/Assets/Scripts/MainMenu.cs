using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MainMenu : MonoBehaviour
{
    public string startLevel;

    public string levelSelect;

    public void NewGame()
    {
        Application.LoadLevel(startLevel);
    }

    public void LevelSelect()
    {
        Application.LoadLevel(levelSelect);
    }

    public void ExitGame()
    {
        Application.Quit();
    }
}
