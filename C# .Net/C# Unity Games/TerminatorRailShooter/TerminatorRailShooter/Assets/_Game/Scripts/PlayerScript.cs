using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerScript : MonoBehaviour
{
    public static System.Action<WeaponData> OnWeaponChanged = delegate { };

    [SerializeField] WeaponData defaultWeapon;

    private Camera cam;
    private WeaponData currentWeapon;

    // Start is called before the first frame update
    void Start()
    {
        cam = GetComponent<Camera>();

        this.DelayedAction(delegate { SwitchWeapon(); }, 0.1f);
    }


    // Update is called once per frame
    void Update()
    {
        if (currentWeapon != null && !GameManager.Instance.PlayerDead)
            currentWeapon.WeaponUpdate();
    }

    public void SwitchWeapon(WeaponData weapon = null)
    {
        currentWeapon = weapon != null ? weapon : defaultWeapon;
        OnWeaponChanged(currentWeapon);
        currentWeapon.SetupWeapon(cam, this);
    }
}
