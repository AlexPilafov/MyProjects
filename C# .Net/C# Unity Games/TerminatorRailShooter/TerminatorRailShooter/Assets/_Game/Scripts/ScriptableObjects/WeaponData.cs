using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[CreateAssetMenu(fileName ="CustomWeaponData", menuName ="Weapon Data")]
public class WeaponData : ScriptableObject
{
    public System.Action<int> OnWeaponFired = delegate { };

    [SerializeField] FireType type;
    [SerializeField] float rate = 0.15f;
    [SerializeField] int maxAmmo;
    [SerializeField] int damageValue;
    [SerializeField] bool defaultWeapon;
    [SerializeField] Sprite weaponIcon;

    private Camera cam;
    private PlayerScript player;
    private int currentAmmo;
    private float nextFireTime;

    public Sprite GetIcon { get => weaponIcon; }

    public void SetupWeapon(Camera cam, PlayerScript player)
    {
        this.cam = cam;
        this.player = player;
        nextFireTime = 0f;
        currentAmmo = maxAmmo;
        OnWeaponFired(currentAmmo);
    }

    public void WeaponUpdate()
    {
        if (type == FireType.SINGLE)
        {
            if (Input.GetMouseButtonDown(0) && currentAmmo > 0)
            {
                Fire();
                currentAmmo--;
                OnWeaponFired(currentAmmo);
            }
            else
            {
                Debug.Log("No ammo, please reload.");
            }
        }
        else
        {
            if (Input.GetMouseButtonDown(0) && Time.time > nextFireTime && currentAmmo > 0)
            {
                Fire();
                currentAmmo--;
                OnWeaponFired(currentAmmo);
                nextFireTime = Time.time + rate;
            }
            else if (currentAmmo <= 0)
            {
                Debug.Log("No ammo, please reload.");
            }
        }

        if (defaultWeapon && Input.GetMouseButtonDown(1))
        {
            currentAmmo = maxAmmo;
            OnWeaponFired(currentAmmo);
        }

        if (!defaultWeapon && currentAmmo <= 0)
        {
            //switch back to default weapon
            player.SwitchWeapon();
        }
    }

    private void Fire()
    {
        RaycastHit hit;
        Ray ray = cam.ScreenPointToRay(Input.mousePosition);

        if (Physics.Raycast(ray, out hit, 50f))
        {
            if (hit.collider != null)
            {
                IHitable[] hitables = hit.collider.GetComponents<IHitable>();

                if (hitables != null && hitables.Length > 0)
                {
                    foreach (var hitable in hitables)
                    {
                        hitable.Hit(hit, damageValue);

                        if (hitable is EnemyScript)
                        {
                            GameManager.Instance.ShotHit(true);
                            return;
                        }
                        else
                        {
                            GameManager.Instance.ShotHit(false);
                        }
                    }

                }

                Debug.Log(hit.collider.gameObject.name);
            }
            return;
        }
        GameManager.Instance.ShotHit(false);
    }
}

public enum FireType
{
    SINGLE,
    RAPID
}
