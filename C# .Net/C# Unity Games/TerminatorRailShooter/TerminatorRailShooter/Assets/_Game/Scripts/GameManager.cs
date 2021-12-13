using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    public static GameManager Instance { get; private set;}

    [SerializeField] GameState state;
    [SerializeField] PlayerMove playerMove;
    [SerializeField] int playerHealth = 100;

    [SerializeField] UiManager uiManager = new UiManager();

    private int enemyHit, shotsFired;
    private float currentHealth;

    public bool PlayerDead { get; private set; }

    private void Awake()
    {
        Instance = this;
    }
    // Start is called before the first frame update
    void Start()
    {
        SwitchState(GameState.Start);
        Init();
    }

    void Init()
    {
        currentHealth = playerHealth;
        uiManager.Init(currentHealth);
    }

    private void OnDisable()
    {
        uiManager.RemoveEvent();
    }

    public void SwitchState(GameState newState)
    {
        if (state == newState)
            return;

        state = newState;
        switch (state)
        {
            case GameState.Start:
                Debug.Log("Game Starts");
                playerMove.enabled = false;
                this.DelayedAction(delegate { SwitchState(GameState.Gameplay); }, 3f);
                break;
            case GameState.Gameplay:
                Debug.Log("State: Gameplay " + Time.time);
                playerMove.enabled = true;
                break;
            case GameState.LevelEnd:
                break;
        }
    }

    public void ShotHit(bool hit)
    {
        if (hit)
            enemyHit++;

        shotsFired++;
    }

    public void PlayerHit(float damage)
    {
        currentHealth -= damage;
        uiManager.UpdateHealth(currentHealth);

        if (currentHealth <= 0f)
        {
            PlayerDead = true;
        }
    }

    private void Update()
    {
        uiManager.MoveCrosshair(Input.mousePosition);
    }
}

public enum GameState
{
    Default,
    Start,
    Gameplay,
    LevelEnd
}
