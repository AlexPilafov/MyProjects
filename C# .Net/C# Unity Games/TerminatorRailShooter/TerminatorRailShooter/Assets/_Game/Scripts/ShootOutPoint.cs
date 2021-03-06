using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ShootOutPoint : MonoBehaviour
{
    [SerializeField] EnemyEntry[] enemyList;
    public bool AreaCleared { get; private set; }
    private bool activePoint = false;
    public PlayerMove playerMove;
    private int enemyKilled;

    public void Initialize(PlayerMove value)
    {
        playerMove = value;
    }
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space))
        {
            playerMove.SetPlayerMovement(false);
        }

        if (Input.GetKeyDown(KeyCode.Return) && activePoint)
        {
            playerMove.SetPlayerMovement(true);
            AreaCleared = true;
            activePoint = false;
        }
    }

    public void StartShootOut()
    {
        activePoint = true;
        playerMove.SetPlayerMovement(false);
        StartCoroutine(SendEnemies());
    }

    IEnumerator SendEnemies()
    {
        foreach (var enemy in enemyList)
        {
            yield return new WaitForSeconds(enemy.delay);

            enemy.enemy.Init(this);

            Debug.Log(enemy.enemy.gameObject.name + " Spawned");
        }
    }

    public void EnemyKilled()
    {
        enemyKilled++;

        if (enemyKilled == enemyList.Length)
        {
            playerMove.SetPlayerMovement(true);
            AreaCleared = true;
            activePoint = false;
        }
    }
}

[System.Serializable]
public class EnemyEntry
{
    public EnemyScript enemy;
    public float delay;
}